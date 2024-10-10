package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PartyInformationModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PartyInformationModelTypeFormatValidator implements Validator<PartyInformationModel> {

	private List<ComparisonResult> getComparisonResults(PartyInformationModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<PartyInformationModel> validate(RosettaPath path, PartyInformationModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PartyInformationModel", ValidationType.TYPE_FORMAT, "PartyInformationModel", path, "", error);
		}
		return success("PartyInformationModel", ValidationType.TYPE_FORMAT, "PartyInformationModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PartyInformationModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PartyInformationModel", ValidationType.TYPE_FORMAT, "PartyInformationModel", path, "", res.getError());
				}
				return success("PartyInformationModel", ValidationType.TYPE_FORMAT, "PartyInformationModel", path, "");
			})
			.collect(toList());
	}

}
