package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Bond;
import fpml.confirmation.ConvertibleBond;
import fpml.confirmation.LegalEntity;
import fpml.confirmation.LegalEntityReference;
import fpml.confirmation.Loan;
import fpml.confirmation.Mortgage;
import fpml.confirmation.ReferenceObligation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ReferenceObligationValidator implements Validator<ReferenceObligation> {

	private List<ComparisonResult> getComparisonResults(ReferenceObligation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("bond", (Bond) o.getBond() != null ? 1 : 0, 0, 1), 
				checkCardinality("convertibleBond", (ConvertibleBond) o.getConvertibleBond() != null ? 1 : 0, 0, 1), 
				checkCardinality("mortgage", (Mortgage) o.getMortgage() != null ? 1 : 0, 0, 1), 
				checkCardinality("loan", (Loan) o.getLoan() != null ? 1 : 0, 0, 1), 
				checkCardinality("primaryObligor", (LegalEntity) o.getPrimaryObligor() != null ? 1 : 0, 0, 1), 
				checkCardinality("primaryObligorReference", (LegalEntityReference) o.getPrimaryObligorReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("standardReferenceObligation", (Boolean) o.getStandardReferenceObligation() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<ReferenceObligation> validate(RosettaPath path, ReferenceObligation o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ReferenceObligation", ValidationType.CARDINALITY, "ReferenceObligation", path, "", error);
		}
		return success("ReferenceObligation", ValidationType.CARDINALITY, "ReferenceObligation", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReferenceObligation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReferenceObligation", ValidationType.CARDINALITY, "ReferenceObligation", path, "", res.getError());
				}
				return success("ReferenceObligation", ValidationType.CARDINALITY, "ReferenceObligation", path, "");
			})
			.collect(toList());
	}

}
