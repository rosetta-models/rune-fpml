package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.InitialMarginCalculationSequence0;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class InitialMarginCalculationSequence0Validator implements Validator<InitialMarginCalculationSequence0> {

	private List<ComparisonResult> getComparisonResults(InitialMarginCalculationSequence0 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("marginRatio", (BigDecimal) o.getMarginRatio() != null ? 1 : 0, 1, 1), 
				checkCardinality("marginRatioThreshold", (List<BigDecimal>) o.getMarginRatioThreshold() == null ? 0 : ((List<BigDecimal>) o.getMarginRatioThreshold()).size(), 0, 2)
			);
	}

	@Override
	public ValidationResult<InitialMarginCalculationSequence0> validate(RosettaPath path, InitialMarginCalculationSequence0 o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("InitialMarginCalculationSequence0", ValidationType.CARDINALITY, "InitialMarginCalculationSequence0", path, "", error);
		}
		return success("InitialMarginCalculationSequence0", ValidationType.CARDINALITY, "InitialMarginCalculationSequence0", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, InitialMarginCalculationSequence0 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("InitialMarginCalculationSequence0", ValidationType.CARDINALITY, "InitialMarginCalculationSequence0", path, "", res.getError());
				}
				return success("InitialMarginCalculationSequence0", ValidationType.CARDINALITY, "InitialMarginCalculationSequence0", path, "");
			})
			.collect(toList());
	}

}
