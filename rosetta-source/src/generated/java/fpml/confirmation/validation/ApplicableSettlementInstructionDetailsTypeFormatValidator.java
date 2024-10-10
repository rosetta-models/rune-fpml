package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ApplicableSettlementInstructionDetails;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ApplicableSettlementInstructionDetailsTypeFormatValidator implements Validator<ApplicableSettlementInstructionDetails> {

	private List<ComparisonResult> getComparisonResults(ApplicableSettlementInstructionDetails o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<ApplicableSettlementInstructionDetails> validate(RosettaPath path, ApplicableSettlementInstructionDetails o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ApplicableSettlementInstructionDetails", ValidationType.TYPE_FORMAT, "ApplicableSettlementInstructionDetails", path, "", error);
		}
		return success("ApplicableSettlementInstructionDetails", ValidationType.TYPE_FORMAT, "ApplicableSettlementInstructionDetails", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ApplicableSettlementInstructionDetails o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ApplicableSettlementInstructionDetails", ValidationType.TYPE_FORMAT, "ApplicableSettlementInstructionDetails", path, "", res.getError());
				}
				return success("ApplicableSettlementInstructionDetails", ValidationType.TYPE_FORMAT, "ApplicableSettlementInstructionDetails", path, "");
			})
			.collect(toList());
	}

}
