package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.GenericEquityAttributesModel;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class GenericEquityAttributesModelValidator implements Validator<GenericEquityAttributesModel> {

	private List<ComparisonResult> getComparisonResults(GenericEquityAttributesModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("optionEntitlement", (BigDecimal) o.getOptionEntitlement() != null ? 1 : 0, 1, 1), 
				checkCardinality("numberOfOptions", (BigDecimal) o.getNumberOfOptions() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<GenericEquityAttributesModel> validate(RosettaPath path, GenericEquityAttributesModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("GenericEquityAttributesModel", ValidationType.CARDINALITY, "GenericEquityAttributesModel", path, "", error);
		}
		return success("GenericEquityAttributesModel", ValidationType.CARDINALITY, "GenericEquityAttributesModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, GenericEquityAttributesModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("GenericEquityAttributesModel", ValidationType.CARDINALITY, "GenericEquityAttributesModel", path, "", res.getError());
				}
				return success("GenericEquityAttributesModel", ValidationType.CARDINALITY, "GenericEquityAttributesModel", path, "");
			})
			.collect(toList());
	}

}
