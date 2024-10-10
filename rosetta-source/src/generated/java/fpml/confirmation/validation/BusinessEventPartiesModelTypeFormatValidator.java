package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BusinessEventPartiesModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class BusinessEventPartiesModelTypeFormatValidator implements Validator<BusinessEventPartiesModel> {

	private List<ComparisonResult> getComparisonResults(BusinessEventPartiesModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<BusinessEventPartiesModel> validate(RosettaPath path, BusinessEventPartiesModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("BusinessEventPartiesModel", ValidationType.TYPE_FORMAT, "BusinessEventPartiesModel", path, "", error);
		}
		return success("BusinessEventPartiesModel", ValidationType.TYPE_FORMAT, "BusinessEventPartiesModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, BusinessEventPartiesModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("BusinessEventPartiesModel", ValidationType.TYPE_FORMAT, "BusinessEventPartiesModel", path, "", res.getError());
				}
				return success("BusinessEventPartiesModel", ValidationType.TYPE_FORMAT, "BusinessEventPartiesModel", path, "");
			})
			.collect(toList());
	}

}
