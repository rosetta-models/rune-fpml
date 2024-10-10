package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.NovationTermsModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class NovationTermsModelTypeFormatValidator implements Validator<NovationTermsModel> {

	private List<ComparisonResult> getComparisonResults(NovationTermsModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<NovationTermsModel> validate(RosettaPath path, NovationTermsModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("NovationTermsModel", ValidationType.TYPE_FORMAT, "NovationTermsModel", path, "", error);
		}
		return success("NovationTermsModel", ValidationType.TYPE_FORMAT, "NovationTermsModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NovationTermsModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NovationTermsModel", ValidationType.TYPE_FORMAT, "NovationTermsModel", path, "", res.getError());
				}
				return success("NovationTermsModel", ValidationType.TYPE_FORMAT, "NovationTermsModel", path, "");
			})
			.collect(toList());
	}

}
