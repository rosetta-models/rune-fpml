package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.UnitContractModel;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class UnitContractModelValidator implements Validator<UnitContractModel> {

	private List<ComparisonResult> getComparisonResults(UnitContractModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("numberOfUnits", (BigDecimal) o.getNumberOfUnits() != null ? 1 : 0, 1, 1), 
				checkCardinality("unitPrice", (NonNegativeMoney) o.getUnitPrice() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<UnitContractModel> validate(RosettaPath path, UnitContractModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("UnitContractModel", ValidationType.CARDINALITY, "UnitContractModel", path, "", error);
		}
		return success("UnitContractModel", ValidationType.CARDINALITY, "UnitContractModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, UnitContractModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("UnitContractModel", ValidationType.CARDINALITY, "UnitContractModel", path, "", res.getError());
				}
				return success("UnitContractModel", ValidationType.CARDINALITY, "UnitContractModel", path, "");
			})
			.collect(toList());
	}

}
