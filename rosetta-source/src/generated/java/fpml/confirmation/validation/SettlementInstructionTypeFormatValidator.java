package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.SettlementInstruction;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SettlementInstructionTypeFormatValidator implements Validator<SettlementInstruction> {

	private List<ComparisonResult> getComparisonResults(SettlementInstruction o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<SettlementInstruction> validate(RosettaPath path, SettlementInstruction o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("SettlementInstruction", ValidationType.TYPE_FORMAT, "SettlementInstruction", path, "", error);
		}
		return success("SettlementInstruction", ValidationType.TYPE_FORMAT, "SettlementInstruction", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SettlementInstruction o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SettlementInstruction", ValidationType.TYPE_FORMAT, "SettlementInstruction", path, "", res.getError());
				}
				return success("SettlementInstruction", ValidationType.TYPE_FORMAT, "SettlementInstruction", path, "");
			})
			.collect(toList());
	}

}
