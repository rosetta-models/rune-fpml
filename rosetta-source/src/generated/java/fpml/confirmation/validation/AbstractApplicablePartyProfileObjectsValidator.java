package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AbstractApplicablePartyProfileObjects;
import fpml.confirmation.ApplicableAssets;
import fpml.confirmation.AssociationToAssetIdentifier;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class AbstractApplicablePartyProfileObjectsValidator implements Validator<AbstractApplicablePartyProfileObjects> {

	private List<ComparisonResult> getComparisonResults(AbstractApplicablePartyProfileObjects o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("identifier", (AssociationToAssetIdentifier) o.getIdentifier() != null ? 1 : 0, 1, 1), 
				checkCardinality("applicableAssets", (ApplicableAssets) o.getApplicableAssets() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<AbstractApplicablePartyProfileObjects> validate(RosettaPath path, AbstractApplicablePartyProfileObjects o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("AbstractApplicablePartyProfileObjects", ValidationType.CARDINALITY, "AbstractApplicablePartyProfileObjects", path, "", error);
		}
		return success("AbstractApplicablePartyProfileObjects", ValidationType.CARDINALITY, "AbstractApplicablePartyProfileObjects", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AbstractApplicablePartyProfileObjects o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AbstractApplicablePartyProfileObjects", ValidationType.CARDINALITY, "AbstractApplicablePartyProfileObjects", path, "", res.getError());
				}
				return success("AbstractApplicablePartyProfileObjects", ValidationType.CARDINALITY, "AbstractApplicablePartyProfileObjects", path, "");
			})
			.collect(toList());
	}

}
