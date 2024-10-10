package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.QuotationCharacteristicsModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class QuotationCharacteristicsModelTypeFormatValidator implements Validator<QuotationCharacteristicsModel> {

	private List<ComparisonResult> getComparisonResults(QuotationCharacteristicsModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<QuotationCharacteristicsModel> validate(RosettaPath path, QuotationCharacteristicsModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("QuotationCharacteristicsModel", ValidationType.TYPE_FORMAT, "QuotationCharacteristicsModel", path, "", error);
		}
		return success("QuotationCharacteristicsModel", ValidationType.TYPE_FORMAT, "QuotationCharacteristicsModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, QuotationCharacteristicsModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("QuotationCharacteristicsModel", ValidationType.TYPE_FORMAT, "QuotationCharacteristicsModel", path, "", res.getError());
				}
				return success("QuotationCharacteristicsModel", ValidationType.TYPE_FORMAT, "QuotationCharacteristicsModel", path, "");
			})
			.collect(toList());
	}

}
