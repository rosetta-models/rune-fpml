package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PostTradeEventsBaseModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PostTradeEventsBaseModelTypeFormatValidator implements Validator<PostTradeEventsBaseModel> {

	private List<ComparisonResult> getComparisonResults(PostTradeEventsBaseModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<PostTradeEventsBaseModel> validate(RosettaPath path, PostTradeEventsBaseModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PostTradeEventsBaseModel", ValidationType.TYPE_FORMAT, "PostTradeEventsBaseModel", path, "", error);
		}
		return success("PostTradeEventsBaseModel", ValidationType.TYPE_FORMAT, "PostTradeEventsBaseModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PostTradeEventsBaseModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PostTradeEventsBaseModel", ValidationType.TYPE_FORMAT, "PostTradeEventsBaseModel", path, "", res.getError());
				}
				return success("PostTradeEventsBaseModel", ValidationType.TYPE_FORMAT, "PostTradeEventsBaseModel", path, "");
			})
			.collect(toList());
	}

}
