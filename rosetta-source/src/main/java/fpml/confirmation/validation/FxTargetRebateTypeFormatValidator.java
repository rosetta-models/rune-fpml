package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxTargetRebate;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxTargetRebateTypeFormatValidator implements Validator<FxTargetRebate> {

	private List<ComparisonResult> getComparisonResults(FxTargetRebate o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FxTargetRebate> validate(RosettaPath path, FxTargetRebate o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxTargetRebate", ValidationType.TYPE_FORMAT, "FxTargetRebate", path, "", error);
		}
		return success("FxTargetRebate", ValidationType.TYPE_FORMAT, "FxTargetRebate", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTargetRebate o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxTargetRebate", ValidationType.TYPE_FORMAT, "FxTargetRebate", path, "", res.getError());
				}
				return success("FxTargetRebate", ValidationType.TYPE_FORMAT, "FxTargetRebate", path, "");
			})
			.collect(toList());
	}

}
