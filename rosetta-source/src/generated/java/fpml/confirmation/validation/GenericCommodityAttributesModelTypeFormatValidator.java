package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.GenericCommodityAttributesModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class GenericCommodityAttributesModelTypeFormatValidator implements Validator<GenericCommodityAttributesModel> {

	private List<ComparisonResult> getComparisonResults(GenericCommodityAttributesModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<GenericCommodityAttributesModel> validate(RosettaPath path, GenericCommodityAttributesModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("GenericCommodityAttributesModel", ValidationType.TYPE_FORMAT, "GenericCommodityAttributesModel", path, "", error);
		}
		return success("GenericCommodityAttributesModel", ValidationType.TYPE_FORMAT, "GenericCommodityAttributesModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, GenericCommodityAttributesModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("GenericCommodityAttributesModel", ValidationType.TYPE_FORMAT, "GenericCommodityAttributesModel", path, "", res.getError());
				}
				return success("GenericCommodityAttributesModel", ValidationType.TYPE_FORMAT, "GenericCommodityAttributesModel", path, "");
			})
			.collect(toList());
	}

}
