package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityInformationProvider;
import fpml.confirmation.CommodityInformationSource;
import fpml.confirmation.RateSourcePage;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityInformationSourceValidator implements Validator<CommodityInformationSource> {

	private List<ComparisonResult> getComparisonResults(CommodityInformationSource o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("rateSource", (CommodityInformationProvider) o.getRateSource() != null ? 1 : 0, 1, 1), 
				checkCardinality("rateSourcePage", (RateSourcePage) o.getRateSourcePage() != null ? 1 : 0, 0, 1), 
				checkCardinality("rateSourcePageHeading", (String) o.getRateSourcePageHeading() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CommodityInformationSource> validate(RosettaPath path, CommodityInformationSource o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityInformationSource", ValidationType.CARDINALITY, "CommodityInformationSource", path, "", error);
		}
		return success("CommodityInformationSource", ValidationType.CARDINALITY, "CommodityInformationSource", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityInformationSource o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityInformationSource", ValidationType.CARDINALITY, "CommodityInformationSource", path, "", res.getError());
				}
				return success("CommodityInformationSource", ValidationType.CARDINALITY, "CommodityInformationSource", path, "");
			})
			.collect(toList());
	}

}
