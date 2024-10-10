package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.NettedSwapBase;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class NettedSwapBaseTypeFormatValidator implements Validator<NettedSwapBase> {

	private List<ComparisonResult> getComparisonResults(NettedSwapBase o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<NettedSwapBase> validate(RosettaPath path, NettedSwapBase o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("NettedSwapBase", ValidationType.TYPE_FORMAT, "NettedSwapBase", path, "", error);
		}
		return success("NettedSwapBase", ValidationType.TYPE_FORMAT, "NettedSwapBase", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NettedSwapBase o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NettedSwapBase", ValidationType.TYPE_FORMAT, "NettedSwapBase", path, "", res.getError());
				}
				return success("NettedSwapBase", ValidationType.TYPE_FORMAT, "NettedSwapBase", path, "");
			})
			.collect(toList());
	}

}
