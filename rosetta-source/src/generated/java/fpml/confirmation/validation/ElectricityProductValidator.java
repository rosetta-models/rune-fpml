package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ElectricityProduct;
import fpml.confirmation.ElectricityProductTypeEnum;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ElectricityProductValidator implements Validator<ElectricityProduct> {

	private List<ComparisonResult> getComparisonResults(ElectricityProduct o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("type", (ElectricityProductTypeEnum) o.getType_() != null ? 1 : 0, 1, 1), 
				checkCardinality("voltage", (BigDecimal) o.getVoltage() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<ElectricityProduct> validate(RosettaPath path, ElectricityProduct o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ElectricityProduct", ValidationType.CARDINALITY, "ElectricityProduct", path, "", error);
		}
		return success("ElectricityProduct", ValidationType.CARDINALITY, "ElectricityProduct", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ElectricityProduct o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ElectricityProduct", ValidationType.CARDINALITY, "ElectricityProduct", path, "", res.getError());
				}
				return success("ElectricityProduct", ValidationType.CARDINALITY, "ElectricityProduct", path, "");
			})
			.collect(toList());
	}

}
