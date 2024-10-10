package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CreditEntityModel;
import fpml.confirmation.LegalEntity;
import fpml.confirmation.LegalEntityReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CreditEntityModelValidator implements Validator<CreditEntityModel> {

	private List<ComparisonResult> getComparisonResults(CreditEntityModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("referenceEntity", (LegalEntity) o.getReferenceEntity() != null ? 1 : 0, 0, 1), 
				checkCardinality("creditEntityReference", (LegalEntityReference) o.getCreditEntityReference() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CreditEntityModel> validate(RosettaPath path, CreditEntityModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CreditEntityModel", ValidationType.CARDINALITY, "CreditEntityModel", path, "", error);
		}
		return success("CreditEntityModel", ValidationType.CARDINALITY, "CreditEntityModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditEntityModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CreditEntityModel", ValidationType.CARDINALITY, "CreditEntityModel", path, "", res.getError());
				}
				return success("CreditEntityModel", ValidationType.CARDINALITY, "CreditEntityModel", path, "");
			})
			.collect(toList());
	}

}
