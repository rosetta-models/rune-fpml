package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.TradeDifference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TradeDifferenceTypeFormatValidator implements Validator<TradeDifference> {

	private List<ComparisonResult> getComparisonResults(TradeDifference o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("element", o.getElement(), 0, of(255), empty()), 
				checkString("basePath", o.getBasePath(), 0, of(255), empty()), 
				checkString("baseValue", o.getBaseValue(), 0, of(255), empty()), 
				checkString("otherPath", o.getOtherPath(), 0, of(255), empty()), 
				checkString("otherValue", o.getOtherValue(), 0, of(255), empty()), 
				checkString("missingElement", o.getMissingElement(), 0, of(255), empty()), 
				checkString("extraElement", o.getExtraElement(), 0, of(255), empty()), 
				checkString("message", o.getMessage(), 0, of(255), empty())
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
			return failure("TradeDifference", ValidationType.TYPE_FORMAT, "TradeDifference", path, "", error);
		}
		return success("TradeDifference", ValidationType.TYPE_FORMAT, "TradeDifference", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeDifference o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeDifference", ValidationType.TYPE_FORMAT, "TradeDifference", path, "", res.getError());
				}
				return success("TradeDifference", ValidationType.TYPE_FORMAT, "TradeDifference", path, "");
			})
			.collect(toList());
	}

}
