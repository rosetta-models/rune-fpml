package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.LoanTradingSettlementAccrualsModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LoanTradingSettlementAccrualsModelTypeFormatValidator implements Validator<LoanTradingSettlementAccrualsModel> {

	private List<ComparisonResult> getComparisonResults(LoanTradingSettlementAccrualsModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<LoanTradingSettlementAccrualsModel> validate(RosettaPath path, LoanTradingSettlementAccrualsModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LoanTradingSettlementAccrualsModel", ValidationType.TYPE_FORMAT, "LoanTradingSettlementAccrualsModel", path, "", error);
		}
		return success("LoanTradingSettlementAccrualsModel", ValidationType.TYPE_FORMAT, "LoanTradingSettlementAccrualsModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanTradingSettlementAccrualsModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanTradingSettlementAccrualsModel", ValidationType.TYPE_FORMAT, "LoanTradingSettlementAccrualsModel", path, "", res.getError());
				}
				return success("LoanTradingSettlementAccrualsModel", ValidationType.TYPE_FORMAT, "LoanTradingSettlementAccrualsModel", path, "");
			})
			.collect(toList());
	}

}
