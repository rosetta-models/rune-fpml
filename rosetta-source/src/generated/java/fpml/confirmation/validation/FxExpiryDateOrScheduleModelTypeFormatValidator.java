package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxExpiryDateOrScheduleModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxExpiryDateOrScheduleModelTypeFormatValidator implements Validator<FxExpiryDateOrScheduleModel> {

	private List<ComparisonResult> getComparisonResults(FxExpiryDateOrScheduleModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FxExpiryDateOrScheduleModel> validate(RosettaPath path, FxExpiryDateOrScheduleModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxExpiryDateOrScheduleModel", ValidationType.TYPE_FORMAT, "FxExpiryDateOrScheduleModel", path, "", error);
		}
		return success("FxExpiryDateOrScheduleModel", ValidationType.TYPE_FORMAT, "FxExpiryDateOrScheduleModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxExpiryDateOrScheduleModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxExpiryDateOrScheduleModel", ValidationType.TYPE_FORMAT, "FxExpiryDateOrScheduleModel", path, "", res.getError());
				}
				return success("FxExpiryDateOrScheduleModel", ValidationType.TYPE_FORMAT, "FxExpiryDateOrScheduleModel", path, "");
			})
			.collect(toList());
	}

}
