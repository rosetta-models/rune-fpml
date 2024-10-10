package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.LoanTradingLetterOfCreditAccrual;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LoanTradingLetterOfCreditAccrualTypeFormatValidator implements Validator<LoanTradingLetterOfCreditAccrual> {

	private List<ComparisonResult> getComparisonResults(LoanTradingLetterOfCreditAccrual o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<LoanTradingLetterOfCreditAccrual> validate(RosettaPath path, LoanTradingLetterOfCreditAccrual o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LoanTradingLetterOfCreditAccrual", ValidationType.TYPE_FORMAT, "LoanTradingLetterOfCreditAccrual", path, "", error);
		}
		return success("LoanTradingLetterOfCreditAccrual", ValidationType.TYPE_FORMAT, "LoanTradingLetterOfCreditAccrual", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanTradingLetterOfCreditAccrual o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanTradingLetterOfCreditAccrual", ValidationType.TYPE_FORMAT, "LoanTradingLetterOfCreditAccrual", path, "", res.getError());
				}
				return success("LoanTradingLetterOfCreditAccrual", ValidationType.TYPE_FORMAT, "LoanTradingLetterOfCreditAccrual", path, "");
			})
			.collect(toList());
	}

}
