package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BusinessCenterTime;
import fpml.confirmation.FxInformationSource;
import fpml.confirmation.InformationProvider;
import fpml.confirmation.RateSourcePage;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxInformationSourceValidator implements Validator<FxInformationSource> {

	private List<ComparisonResult> getComparisonResults(FxInformationSource o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("rateSource", (InformationProvider) o.getRateSource() != null ? 1 : 0, 1, 1), 
				checkCardinality("rateSourcePage", (RateSourcePage) o.getRateSourcePage() != null ? 1 : 0, 0, 1), 
				checkCardinality("rateSourcePageHeading", (String) o.getRateSourcePageHeading() != null ? 1 : 0, 0, 1), 
				checkCardinality("fixingTime", (BusinessCenterTime) o.getFixingTime() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<FxInformationSource> validate(RosettaPath path, FxInformationSource o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxInformationSource", ValidationType.CARDINALITY, "FxInformationSource", path, "", error);
		}
		return success("FxInformationSource", ValidationType.CARDINALITY, "FxInformationSource", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxInformationSource o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxInformationSource", ValidationType.CARDINALITY, "FxInformationSource", path, "", res.getError());
				}
				return success("FxInformationSource", ValidationType.CARDINALITY, "FxInformationSource", path, "");
			})
			.collect(toList());
	}

}
