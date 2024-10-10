package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BasketChangeEvent;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class BasketChangeEventValidator implements Validator<BasketChangeEvent> {

	private List<ComparisonResult> getComparisonResults(BasketChangeEvent o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<BasketChangeEvent> validate(RosettaPath path, BasketChangeEvent o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("BasketChangeEvent", ValidationType.CARDINALITY, "BasketChangeEvent", path, "", error);
		}
		return success("BasketChangeEvent", ValidationType.CARDINALITY, "BasketChangeEvent", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, BasketChangeEvent o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("BasketChangeEvent", ValidationType.CARDINALITY, "BasketChangeEvent", path, "", res.getError());
				}
				return success("BasketChangeEvent", ValidationType.CARDINALITY, "BasketChangeEvent", path, "");
			})
			.collect(toList());
	}

}
