package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.OldTradeModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class OldTradeModelTypeFormatValidator implements Validator<OldTradeModel> {

	private List<ComparisonResult> getComparisonResults(OldTradeModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<OldTradeModel> validate(RosettaPath path, OldTradeModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("OldTradeModel", ValidationType.TYPE_FORMAT, "OldTradeModel", path, "", error);
		}
		return success("OldTradeModel", ValidationType.TYPE_FORMAT, "OldTradeModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OldTradeModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OldTradeModel", ValidationType.TYPE_FORMAT, "OldTradeModel", path, "", res.getError());
				}
				return success("OldTradeModel", ValidationType.TYPE_FORMAT, "OldTradeModel", path, "");
			})
			.collect(toList());
	}

}
