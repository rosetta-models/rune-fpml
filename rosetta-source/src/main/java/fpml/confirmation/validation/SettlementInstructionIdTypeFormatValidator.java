package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.SettlementInstructionId;
import java.util.List;
import java.util.regex.Pattern;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SettlementInstructionIdTypeFormatValidator implements Validator<SettlementInstructionId> {

	private List<ComparisonResult> getComparisonResults(SettlementInstructionId o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("settlementInstructionIdScheme", o.getSettlementInstructionIdScheme(), 0, empty(), of(Pattern.compile("\\w+:(\\/?\\/?)[^\\s]+")))
			);
	}

	@Override
	public ValidationResult<SettlementInstructionId> validate(RosettaPath path, SettlementInstructionId o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("SettlementInstructionId", ValidationType.TYPE_FORMAT, "SettlementInstructionId", path, "", error);
		}
		return success("SettlementInstructionId", ValidationType.TYPE_FORMAT, "SettlementInstructionId", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SettlementInstructionId o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SettlementInstructionId", ValidationType.TYPE_FORMAT, "SettlementInstructionId", path, "", res.getError());
				}
				return success("SettlementInstructionId", ValidationType.TYPE_FORMAT, "SettlementInstructionId", path, "");
			})
			.collect(toList());
	}

}
