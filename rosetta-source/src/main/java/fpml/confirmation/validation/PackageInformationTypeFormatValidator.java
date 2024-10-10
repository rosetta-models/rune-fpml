package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PackageInformation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PackageInformationTypeFormatValidator implements Validator<PackageInformation> {

	private List<ComparisonResult> getComparisonResults(PackageInformation o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<PackageInformation> validate(RosettaPath path, PackageInformation o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PackageInformation", ValidationType.TYPE_FORMAT, "PackageInformation", path, "", error);
		}
		return success("PackageInformation", ValidationType.TYPE_FORMAT, "PackageInformation", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PackageInformation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PackageInformation", ValidationType.TYPE_FORMAT, "PackageInformation", path, "", res.getError());
				}
				return success("PackageInformation", ValidationType.TYPE_FORMAT, "PackageInformation", path, "");
			})
			.collect(toList());
	}

}
