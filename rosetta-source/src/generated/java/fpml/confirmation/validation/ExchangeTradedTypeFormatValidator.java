package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ExchangeTraded;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ExchangeTradedTypeFormatValidator implements Validator<ExchangeTraded> {

	private List<ComparisonResult> getComparisonResults(ExchangeTraded o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("description", o.getDescription(), 0, of(255), empty())
			);
	}

	@Override
	public ValidationResult<ExchangeTraded> validate(RosettaPath path, ExchangeTraded o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ExchangeTraded", ValidationType.TYPE_FORMAT, "ExchangeTraded", path, "", error);
		}
		return success("ExchangeTraded", ValidationType.TYPE_FORMAT, "ExchangeTraded", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExchangeTraded o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ExchangeTraded", ValidationType.TYPE_FORMAT, "ExchangeTraded", path, "", res.getError());
				}
				return success("ExchangeTraded", ValidationType.TYPE_FORMAT, "ExchangeTraded", path, "");
			})
			.collect(toList());
	}

}
