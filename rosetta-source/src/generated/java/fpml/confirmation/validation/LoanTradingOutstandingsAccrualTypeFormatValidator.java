package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.LoanTradingOutstandingsAccrual;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LoanTradingOutstandingsAccrualTypeFormatValidator implements Validator<LoanTradingOutstandingsAccrual> {

	private List<ComparisonResult> getComparisonResults(LoanTradingOutstandingsAccrual o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<LoanTradingOutstandingsAccrual> validate(RosettaPath path, LoanTradingOutstandingsAccrual o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LoanTradingOutstandingsAccrual", ValidationType.TYPE_FORMAT, "LoanTradingOutstandingsAccrual", path, "", error);
		}
		return success("LoanTradingOutstandingsAccrual", ValidationType.TYPE_FORMAT, "LoanTradingOutstandingsAccrual", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanTradingOutstandingsAccrual o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanTradingOutstandingsAccrual", ValidationType.TYPE_FORMAT, "LoanTradingOutstandingsAccrual", path, "", res.getError());
				}
				return success("LoanTradingOutstandingsAccrual", ValidationType.TYPE_FORMAT, "LoanTradingOutstandingsAccrual", path, "");
			})
			.collect(toList());
	}

}
