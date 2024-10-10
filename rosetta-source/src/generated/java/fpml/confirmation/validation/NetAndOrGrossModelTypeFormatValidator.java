package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.NetAndOrGrossModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class NetAndOrGrossModelTypeFormatValidator implements Validator<NetAndOrGrossModel> {

	private List<ComparisonResult> getComparisonResults(NetAndOrGrossModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<NetAndOrGrossModel> validate(RosettaPath path, NetAndOrGrossModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("NetAndOrGrossModel", ValidationType.TYPE_FORMAT, "NetAndOrGrossModel", path, "", error);
		}
		return success("NetAndOrGrossModel", ValidationType.TYPE_FORMAT, "NetAndOrGrossModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NetAndOrGrossModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NetAndOrGrossModel", ValidationType.TYPE_FORMAT, "NetAndOrGrossModel", path, "", res.getError());
				}
				return success("NetAndOrGrossModel", ValidationType.TYPE_FORMAT, "NetAndOrGrossModel", path, "");
			})
			.collect(toList());
	}

}
