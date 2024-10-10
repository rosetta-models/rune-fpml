package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.LoanTradingTransferFeeDeterminationModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LoanTradingTransferFeeDeterminationModelTypeFormatValidator implements Validator<LoanTradingTransferFeeDeterminationModel> {

	private List<ComparisonResult> getComparisonResults(LoanTradingTransferFeeDeterminationModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<LoanTradingTransferFeeDeterminationModel> validate(RosettaPath path, LoanTradingTransferFeeDeterminationModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LoanTradingTransferFeeDeterminationModel", ValidationType.TYPE_FORMAT, "LoanTradingTransferFeeDeterminationModel", path, "", error);
		}
		return success("LoanTradingTransferFeeDeterminationModel", ValidationType.TYPE_FORMAT, "LoanTradingTransferFeeDeterminationModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanTradingTransferFeeDeterminationModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanTradingTransferFeeDeterminationModel", ValidationType.TYPE_FORMAT, "LoanTradingTransferFeeDeterminationModel", path, "", res.getError());
				}
				return success("LoanTradingTransferFeeDeterminationModel", ValidationType.TYPE_FORMAT, "LoanTradingTransferFeeDeterminationModel", path, "");
			})
			.collect(toList());
	}

}
