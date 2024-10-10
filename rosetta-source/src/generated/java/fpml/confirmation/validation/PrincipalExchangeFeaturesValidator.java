package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PrincipalExchangeDescriptions;
import fpml.confirmation.PrincipalExchangeFeatures;
import fpml.confirmation.PrincipalExchanges;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PrincipalExchangeFeaturesValidator implements Validator<PrincipalExchangeFeatures> {

	private List<ComparisonResult> getComparisonResults(PrincipalExchangeFeatures o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("principalExchanges", (PrincipalExchanges) o.getPrincipalExchanges() != null ? 1 : 0, 0, 1), 
				checkCardinality("principalExchangeDescriptions", (List<? extends PrincipalExchangeDescriptions>) o.getPrincipalExchangeDescriptions() == null ? 0 : ((List<? extends PrincipalExchangeDescriptions>) o.getPrincipalExchangeDescriptions()).size(), 1, 0)
			);
	}

	@Override
	public ValidationResult<PrincipalExchangeFeatures> validate(RosettaPath path, PrincipalExchangeFeatures o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PrincipalExchangeFeatures", ValidationType.CARDINALITY, "PrincipalExchangeFeatures", path, "", error);
		}
		return success("PrincipalExchangeFeatures", ValidationType.CARDINALITY, "PrincipalExchangeFeatures", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PrincipalExchangeFeatures o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PrincipalExchangeFeatures", ValidationType.CARDINALITY, "PrincipalExchangeFeatures", path, "", res.getError());
				}
				return success("PrincipalExchangeFeatures", ValidationType.CARDINALITY, "PrincipalExchangeFeatures", path, "");
			})
			.collect(toList());
	}

}
