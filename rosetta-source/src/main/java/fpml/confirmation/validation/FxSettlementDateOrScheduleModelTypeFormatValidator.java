package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxSettlementDateOrScheduleModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxSettlementDateOrScheduleModelTypeFormatValidator implements Validator<FxSettlementDateOrScheduleModel> {

	private List<ComparisonResult> getComparisonResults(FxSettlementDateOrScheduleModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FxSettlementDateOrScheduleModel> validate(RosettaPath path, FxSettlementDateOrScheduleModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxSettlementDateOrScheduleModel", ValidationType.TYPE_FORMAT, "FxSettlementDateOrScheduleModel", path, "", error);
		}
		return success("FxSettlementDateOrScheduleModel", ValidationType.TYPE_FORMAT, "FxSettlementDateOrScheduleModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxSettlementDateOrScheduleModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxSettlementDateOrScheduleModel", ValidationType.TYPE_FORMAT, "FxSettlementDateOrScheduleModel", path, "", res.getError());
				}
				return success("FxSettlementDateOrScheduleModel", ValidationType.TYPE_FORMAT, "FxSettlementDateOrScheduleModel", path, "");
			})
			.collect(toList());
	}

}
