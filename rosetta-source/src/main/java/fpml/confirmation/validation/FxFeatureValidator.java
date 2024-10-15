package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Composite;
import fpml.confirmation.FxFeature;
import fpml.confirmation.IdentifiedCurrency;
import fpml.confirmation.Quanto;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxFeatureValidator implements Validator<FxFeature> {

	private List<ComparisonResult> getComparisonResults(FxFeature o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("referenceCurrency", (IdentifiedCurrency) o.getReferenceCurrency() != null ? 1 : 0, 1, 1), 
				checkCardinality("composite", (Composite) o.getComposite() != null ? 1 : 0, 0, 1), 
				checkCardinality("quanto", (Quanto) o.getQuanto() != null ? 1 : 0, 0, 1), 
				checkCardinality("crossCurrency", (Composite) o.getCrossCurrency() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<FxFeature> validate(RosettaPath path, FxFeature o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxFeature", ValidationType.CARDINALITY, "FxFeature", path, "", error);
		}
		return success("FxFeature", ValidationType.CARDINALITY, "FxFeature", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxFeature o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxFeature", ValidationType.CARDINALITY, "FxFeature", path, "", res.getError());
				}
				return success("FxFeature", ValidationType.CARDINALITY, "FxFeature", path, "");
			})
			.collect(toList());
	}

}
