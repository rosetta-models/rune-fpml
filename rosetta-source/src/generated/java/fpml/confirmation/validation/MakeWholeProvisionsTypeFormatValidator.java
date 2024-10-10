package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.MakeWholeProvisions;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class MakeWholeProvisionsTypeFormatValidator implements Validator<MakeWholeProvisions> {

	private List<ComparisonResult> getComparisonResults(MakeWholeProvisions o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<MakeWholeProvisions> validate(RosettaPath path, MakeWholeProvisions o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("MakeWholeProvisions", ValidationType.TYPE_FORMAT, "MakeWholeProvisions", path, "", error);
		}
		return success("MakeWholeProvisions", ValidationType.TYPE_FORMAT, "MakeWholeProvisions", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MakeWholeProvisions o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MakeWholeProvisions", ValidationType.TYPE_FORMAT, "MakeWholeProvisions", path, "", res.getError());
				}
				return success("MakeWholeProvisions", ValidationType.TYPE_FORMAT, "MakeWholeProvisions", path, "");
			})
			.collect(toList());
	}

}
