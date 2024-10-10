package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BasicQuotation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class BasicQuotationTypeFormatValidator implements Validator<BasicQuotation> {

	private List<ComparisonResult> getComparisonResults(BasicQuotation o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<BasicQuotation> validate(RosettaPath path, BasicQuotation o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("BasicQuotation", ValidationType.TYPE_FORMAT, "BasicQuotation", path, "", error);
		}
		return success("BasicQuotation", ValidationType.TYPE_FORMAT, "BasicQuotation", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, BasicQuotation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("BasicQuotation", ValidationType.TYPE_FORMAT, "BasicQuotation", path, "", res.getError());
				}
				return success("BasicQuotation", ValidationType.TYPE_FORMAT, "BasicQuotation", path, "");
			})
			.collect(toList());
	}

}
