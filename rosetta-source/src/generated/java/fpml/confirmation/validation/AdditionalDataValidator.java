package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdditionalData;
import fpml.confirmation.MimeType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class AdditionalDataValidator implements Validator<AdditionalData> {

	private List<ComparisonResult> getComparisonResults(AdditionalData o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("mimeType", (MimeType) o.getMimeType() != null ? 1 : 0, 1, 1), 
				checkCardinality("string", (String) o.getString() != null ? 1 : 0, 0, 1), 
				checkCardinality("hexadecimalBinary", (String) o.getHexadecimalBinary() != null ? 1 : 0, 0, 1), 
				checkCardinality("base64Binary", (String) o.getBase64Binary() != null ? 1 : 0, 0, 1), 
				checkCardinality("originalMessage", (String) o.getOriginalMessage() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<AdditionalData> validate(RosettaPath path, AdditionalData o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("AdditionalData", ValidationType.CARDINALITY, "AdditionalData", path, "", error);
		}
		return success("AdditionalData", ValidationType.CARDINALITY, "AdditionalData", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AdditionalData o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AdditionalData", ValidationType.CARDINALITY, "AdditionalData", path, "", res.getError());
				}
				return success("AdditionalData", ValidationType.CARDINALITY, "AdditionalData", path, "");
			})
			.collect(toList());
	}

}
