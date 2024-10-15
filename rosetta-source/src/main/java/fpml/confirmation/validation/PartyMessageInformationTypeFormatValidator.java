package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PartyMessageInformation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PartyMessageInformationTypeFormatValidator implements Validator<PartyMessageInformation> {

	private List<ComparisonResult> getComparisonResults(PartyMessageInformation o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<PartyMessageInformation> validate(RosettaPath path, PartyMessageInformation o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PartyMessageInformation", ValidationType.TYPE_FORMAT, "PartyMessageInformation", path, "", error);
		}
		return success("PartyMessageInformation", ValidationType.TYPE_FORMAT, "PartyMessageInformation", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PartyMessageInformation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PartyMessageInformation", ValidationType.TYPE_FORMAT, "PartyMessageInformation", path, "", res.getError());
				}
				return success("PartyMessageInformation", ValidationType.TYPE_FORMAT, "PartyMessageInformation", path, "");
			})
			.collect(toList());
	}

}
