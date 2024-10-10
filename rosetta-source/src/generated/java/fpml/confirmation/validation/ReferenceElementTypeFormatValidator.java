package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ReferenceElement;
import java.util.List;
import java.util.regex.Pattern;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ReferenceElementTypeFormatValidator implements Validator<ReferenceElement> {

	private List<ComparisonResult> getComparisonResults(ReferenceElement o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("uri", o.getUri(), 0, empty(), of(Pattern.compile("\\w+:(\\/?\\/?)[^\\s]+"))), 
				checkString("type", o.getType(), 0, empty(), of(Pattern.compile("\\w+:(\\/?\\/?)[^\\s]+")))
			);
	}

	@Override
	public ValidationResult<ReferenceElement> validate(RosettaPath path, ReferenceElement o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ReferenceElement", ValidationType.TYPE_FORMAT, "ReferenceElement", path, "", error);
		}
		return success("ReferenceElement", ValidationType.TYPE_FORMAT, "ReferenceElement", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReferenceElement o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReferenceElement", ValidationType.TYPE_FORMAT, "ReferenceElement", path, "", res.getError());
				}
				return success("ReferenceElement", ValidationType.TYPE_FORMAT, "ReferenceElement", path, "");
			})
			.collect(toList());
	}

}
