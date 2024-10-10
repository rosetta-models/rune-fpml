package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.TradeLegNumberOfUnitsChangeModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TradeLegNumberOfUnitsChangeModelTypeFormatValidator implements Validator<TradeLegNumberOfUnitsChangeModel> {

	private List<ComparisonResult> getComparisonResults(TradeLegNumberOfUnitsChangeModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<TradeLegNumberOfUnitsChangeModel> validate(RosettaPath path, TradeLegNumberOfUnitsChangeModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TradeLegNumberOfUnitsChangeModel", ValidationType.TYPE_FORMAT, "TradeLegNumberOfUnitsChangeModel", path, "", error);
		}
		return success("TradeLegNumberOfUnitsChangeModel", ValidationType.TYPE_FORMAT, "TradeLegNumberOfUnitsChangeModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeLegNumberOfUnitsChangeModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeLegNumberOfUnitsChangeModel", ValidationType.TYPE_FORMAT, "TradeLegNumberOfUnitsChangeModel", path, "", res.getError());
				}
				return success("TradeLegNumberOfUnitsChangeModel", ValidationType.TYPE_FORMAT, "TradeLegNumberOfUnitsChangeModel", path, "");
			})
			.collect(toList());
	}

}
