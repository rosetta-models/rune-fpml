package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Language;
import fpml.confirmation.MimeType;
import fpml.confirmation.Resource;
import fpml.confirmation.ResourceId;
import fpml.confirmation.ResourceLength;
import fpml.confirmation.ResourceType;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ResourceValidator implements Validator<Resource> {

	private List<ComparisonResult> getComparisonResults(Resource o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("resourceId", (ResourceId) o.getResourceId() != null ? 1 : 0, 1, 1), 
				checkCardinality("resourceType", (ResourceType) o.getResourceType() != null ? 1 : 0, 0, 1), 
				checkCardinality("language", (Language) o.getLanguage() != null ? 1 : 0, 0, 1), 
				checkCardinality("sizeInBytes", (BigDecimal) o.getSizeInBytes() != null ? 1 : 0, 0, 1), 
				checkCardinality("length", (ResourceLength) o.getLength() != null ? 1 : 0, 0, 1), 
				checkCardinality("mimeType", (MimeType) o.getMimeType() != null ? 1 : 0, 1, 1), 
				checkCardinality("name", (String) o.getName() != null ? 1 : 0, 0, 1), 
				checkCardinality("comments", (String) o.getComments() != null ? 1 : 0, 0, 1), 
				checkCardinality("string", (String) o.getString() != null ? 1 : 0, 0, 1), 
				checkCardinality("hexadecimalBinary", (String) o.getHexadecimalBinary() != null ? 1 : 0, 0, 1), 
				checkCardinality("base64Binary", (String) o.getBase64Binary() != null ? 1 : 0, 0, 1), 
				checkCardinality("url", (String) o.getUrl() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<Resource> validate(RosettaPath path, Resource o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Resource", ValidationType.CARDINALITY, "Resource", path, "", error);
		}
		return success("Resource", ValidationType.CARDINALITY, "Resource", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Resource o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Resource", ValidationType.CARDINALITY, "Resource", path, "", res.getError());
				}
				return success("Resource", ValidationType.CARDINALITY, "Resource", path, "");
			})
			.collect(toList());
	}

}
