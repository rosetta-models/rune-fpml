package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.VersionedTradeId;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class VersionedTradeIdTypeFormatValidator implements Validator<VersionedTradeId> {

	private List<ComparisonResult> getComparisonResults(VersionedTradeId o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<VersionedTradeId> validate(RosettaPath path, VersionedTradeId o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("VersionedTradeId", ValidationType.TYPE_FORMAT, "VersionedTradeId", path, "", error);
		}
		return success("VersionedTradeId", ValidationType.TYPE_FORMAT, "VersionedTradeId", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, VersionedTradeId o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("VersionedTradeId", ValidationType.TYPE_FORMAT, "VersionedTradeId", path, "", res.getError());
				}
				return success("VersionedTradeId", ValidationType.TYPE_FORMAT, "VersionedTradeId", path, "");
			})
			.collect(toList());
	}

}
