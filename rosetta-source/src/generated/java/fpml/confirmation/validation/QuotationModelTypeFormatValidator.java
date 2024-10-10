package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.QuotationModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class QuotationModelTypeFormatValidator implements Validator<QuotationModel> {

	private List<ComparisonResult> getComparisonResults(QuotationModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<QuotationModel> validate(RosettaPath path, QuotationModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("QuotationModel", ValidationType.TYPE_FORMAT, "QuotationModel", path, "", error);
		}
		return success("QuotationModel", ValidationType.TYPE_FORMAT, "QuotationModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, QuotationModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("QuotationModel", ValidationType.TYPE_FORMAT, "QuotationModel", path, "", res.getError());
				}
				return success("QuotationModel", ValidationType.TYPE_FORMAT, "QuotationModel", path, "");
			})
			.collect(toList());
	}

}
