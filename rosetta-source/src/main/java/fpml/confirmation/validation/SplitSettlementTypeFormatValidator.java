package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.SplitSettlement;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SplitSettlementTypeFormatValidator implements Validator<SplitSettlement> {

	private List<ComparisonResult> getComparisonResults(SplitSettlement o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<SplitSettlement> validate(RosettaPath path, SplitSettlement o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("SplitSettlement", ValidationType.TYPE_FORMAT, "SplitSettlement", path, "", error);
		}
		return success("SplitSettlement", ValidationType.TYPE_FORMAT, "SplitSettlement", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SplitSettlement o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SplitSettlement", ValidationType.TYPE_FORMAT, "SplitSettlement", path, "", res.getError());
				}
				return success("SplitSettlement", ValidationType.TYPE_FORMAT, "SplitSettlement", path, "");
			})
			.collect(toList());
	}

}
