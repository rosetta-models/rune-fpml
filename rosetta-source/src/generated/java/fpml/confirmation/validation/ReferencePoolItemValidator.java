package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ConstituentWeight;
import fpml.confirmation.ProtectionTermsReference;
import fpml.confirmation.ReferencePair;
import fpml.confirmation.ReferencePoolItem;
import fpml.confirmation.SettlementTermsReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ReferencePoolItemValidator implements Validator<ReferencePoolItem> {

	private List<ComparisonResult> getComparisonResults(ReferencePoolItem o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("constituentWeight", (ConstituentWeight) o.getConstituentWeight() != null ? 1 : 0, 0, 1), 
				checkCardinality("referencePair", (ReferencePair) o.getReferencePair() != null ? 1 : 0, 1, 1), 
				checkCardinality("protectionTermsReference", (ProtectionTermsReference) o.getProtectionTermsReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementTermsReference", (SettlementTermsReference) o.getSettlementTermsReference() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<ReferencePoolItem> validate(RosettaPath path, ReferencePoolItem o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ReferencePoolItem", ValidationType.CARDINALITY, "ReferencePoolItem", path, "", error);
		}
		return success("ReferencePoolItem", ValidationType.CARDINALITY, "ReferencePoolItem", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReferencePoolItem o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReferencePoolItem", ValidationType.CARDINALITY, "ReferencePoolItem", path, "", res.getError());
				}
				return success("ReferencePoolItem", ValidationType.CARDINALITY, "ReferencePoolItem", path, "");
			})
			.collect(toList());
	}

}
