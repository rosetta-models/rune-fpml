package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CreditEventNoticeDocument;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CreditEventNoticeDocumentTypeFormatValidator implements Validator<CreditEventNoticeDocument> {

	private List<ComparisonResult> getComparisonResults(CreditEventNoticeDocument o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CreditEventNoticeDocument> validate(RosettaPath path, CreditEventNoticeDocument o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CreditEventNoticeDocument", ValidationType.TYPE_FORMAT, "CreditEventNoticeDocument", path, "", error);
		}
		return success("CreditEventNoticeDocument", ValidationType.TYPE_FORMAT, "CreditEventNoticeDocument", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditEventNoticeDocument o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CreditEventNoticeDocument", ValidationType.TYPE_FORMAT, "CreditEventNoticeDocument", path, "", res.getError());
				}
				return success("CreditEventNoticeDocument", ValidationType.TYPE_FORMAT, "CreditEventNoticeDocument", path, "");
			})
			.collect(toList());
	}

}
