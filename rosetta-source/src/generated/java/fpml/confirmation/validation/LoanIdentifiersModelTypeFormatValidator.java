package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.LoanIdentifiersModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LoanIdentifiersModelTypeFormatValidator implements Validator<LoanIdentifiersModel> {

	private List<ComparisonResult> getComparisonResults(LoanIdentifiersModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<LoanIdentifiersModel> validate(RosettaPath path, LoanIdentifiersModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LoanIdentifiersModel", ValidationType.TYPE_FORMAT, "LoanIdentifiersModel", path, "", error);
		}
		return success("LoanIdentifiersModel", ValidationType.TYPE_FORMAT, "LoanIdentifiersModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanIdentifiersModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanIdentifiersModel", ValidationType.TYPE_FORMAT, "LoanIdentifiersModel", path, "", res.getError());
				}
				return success("LoanIdentifiersModel", ValidationType.TYPE_FORMAT, "LoanIdentifiersModel", path, "");
			})
			.collect(toList());
	}

}
