package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.SettlementDetails;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SettlementDetailsTypeFormatValidator implements Validator<SettlementDetails> {

	private List<ComparisonResult> getComparisonResults(SettlementDetails o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<SettlementDetails> validate(RosettaPath path, SettlementDetails o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("SettlementDetails", ValidationType.TYPE_FORMAT, "SettlementDetails", path, "", error);
		}
		return success("SettlementDetails", ValidationType.TYPE_FORMAT, "SettlementDetails", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SettlementDetails o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SettlementDetails", ValidationType.TYPE_FORMAT, "SettlementDetails", path, "", res.getError());
				}
				return success("SettlementDetails", ValidationType.TYPE_FORMAT, "SettlementDetails", path, "");
			})
			.collect(toList());
	}

}
