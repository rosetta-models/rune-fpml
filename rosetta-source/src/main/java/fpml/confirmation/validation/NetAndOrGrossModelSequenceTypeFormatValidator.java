package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.NetAndOrGrossModelSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class NetAndOrGrossModelSequenceTypeFormatValidator implements Validator<NetAndOrGrossModelSequence> {

	private List<ComparisonResult> getComparisonResults(NetAndOrGrossModelSequence o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<NetAndOrGrossModelSequence> validate(RosettaPath path, NetAndOrGrossModelSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("NetAndOrGrossModelSequence", ValidationType.TYPE_FORMAT, "NetAndOrGrossModelSequence", path, "", error);
		}
		return success("NetAndOrGrossModelSequence", ValidationType.TYPE_FORMAT, "NetAndOrGrossModelSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NetAndOrGrossModelSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NetAndOrGrossModelSequence", ValidationType.TYPE_FORMAT, "NetAndOrGrossModelSequence", path, "", res.getError());
				}
				return success("NetAndOrGrossModelSequence", ValidationType.TYPE_FORMAT, "NetAndOrGrossModelSequence", path, "");
			})
			.collect(toList());
	}

}
