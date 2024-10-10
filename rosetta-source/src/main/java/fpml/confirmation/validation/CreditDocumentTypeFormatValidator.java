package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CreditDocument;
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

public class CreditDocumentTypeFormatValidator implements Validator<CreditDocument> {

	private List<ComparisonResult> getComparisonResults(CreditDocument o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("creditDocumentScheme", o.getCreditDocumentScheme(), 1, empty(), of(Pattern.compile("\\w+:(\\/?\\/?)[^\\s]+")))
			);
	}

	@Override
	public ValidationResult<CreditDocument> validate(RosettaPath path, CreditDocument o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CreditDocument", ValidationType.TYPE_FORMAT, "CreditDocument", path, "", error);
		}
		return success("CreditDocument", ValidationType.TYPE_FORMAT, "CreditDocument", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditDocument o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CreditDocument", ValidationType.TYPE_FORMAT, "CreditDocument", path, "", res.getError());
				}
				return success("CreditDocument", ValidationType.TYPE_FORMAT, "CreditDocument", path, "");
			})
			.collect(toList());
	}

}
