package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.IndexName;
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

public class IndexNameTypeFormatValidator implements Validator<IndexName> {

	private List<ComparisonResult> getComparisonResults(IndexName o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("indexNameScheme", o.getIndexNameScheme(), 1, empty(), of(Pattern.compile("\\w+:(\\/?\\/?)[^\\s]+")))
			);
	}

	@Override
	public ValidationResult<IndexName> validate(RosettaPath path, IndexName o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("IndexName", ValidationType.TYPE_FORMAT, "IndexName", path, "", error);
		}
		return success("IndexName", ValidationType.TYPE_FORMAT, "IndexName", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, IndexName o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("IndexName", ValidationType.TYPE_FORMAT, "IndexName", path, "", res.getError());
				}
				return success("IndexName", ValidationType.TYPE_FORMAT, "IndexName", path, "");
			})
			.collect(toList());
	}

}
