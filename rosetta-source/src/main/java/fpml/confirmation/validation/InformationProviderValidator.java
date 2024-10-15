package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.InformationProvider;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class InformationProviderValidator implements Validator<InformationProvider> {

	private List<ComparisonResult> getComparisonResults(InformationProvider o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("informationProviderScheme", (String) o.getInformationProviderScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<InformationProvider> validate(RosettaPath path, InformationProvider o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("InformationProvider", ValidationType.CARDINALITY, "InformationProvider", path, "", error);
		}
		return success("InformationProvider", ValidationType.CARDINALITY, "InformationProvider", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, InformationProvider o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("InformationProvider", ValidationType.CARDINALITY, "InformationProvider", path, "", res.getError());
				}
				return success("InformationProvider", ValidationType.CARDINALITY, "InformationProvider", path, "");
			})
			.collect(toList());
	}

}
