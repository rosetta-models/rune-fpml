package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.DifferenceSeverityEnum;
import fpml.confirmation.DifferenceTypeEnum;
import fpml.confirmation.TradeDifference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TradeDifferenceValidator implements Validator<TradeDifference> {

	private List<ComparisonResult> getComparisonResults(TradeDifference o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("differenceType", (DifferenceTypeEnum) o.getDifferenceType() != null ? 1 : 0, 1, 1), 
				checkCardinality("differenceSeverity", (DifferenceSeverityEnum) o.getDifferenceSeverity() != null ? 1 : 0, 1, 1), 
				checkCardinality("element", (String) o.getElement() != null ? 1 : 0, 1, 1), 
				checkCardinality("basePath", (String) o.getBasePath() != null ? 1 : 0, 0, 1), 
				checkCardinality("baseValue", (String) o.getBaseValue() != null ? 1 : 0, 0, 1), 
				checkCardinality("otherPath", (String) o.getOtherPath() != null ? 1 : 0, 0, 1), 
				checkCardinality("otherValue", (String) o.getOtherValue() != null ? 1 : 0, 0, 1), 
				checkCardinality("message", (String) o.getMessage() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<TradeDifference> validate(RosettaPath path, TradeDifference o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TradeDifference", ValidationType.CARDINALITY, "TradeDifference", path, "", error);
		}
		return success("TradeDifference", ValidationType.CARDINALITY, "TradeDifference", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeDifference o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeDifference", ValidationType.CARDINALITY, "TradeDifference", path, "", res.getError());
				}
				return success("TradeDifference", ValidationType.CARDINALITY, "TradeDifference", path, "");
			})
			.collect(toList());
	}

}
