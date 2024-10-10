package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.IndexAnnexSource;
import fpml.confirmation.IndexReferenceInformation;
import fpml.confirmation.IndexReferenceInformationSequence0;
import fpml.confirmation.IndexReferenceInformationSequence1;
import fpml.confirmation.IndexReferenceInformationSequence2;
import fpml.confirmation.SettledEntityMatrix;
import fpml.confirmation.Tranche;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class IndexReferenceInformationValidator implements Validator<IndexReferenceInformation> {

	private List<ComparisonResult> getComparisonResults(IndexReferenceInformation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("indexReferenceInformationSequence0", (IndexReferenceInformationSequence0) o.getIndexReferenceInformationSequence0() != null ? 1 : 0, 0, 1), 
				checkCardinality("indexReferenceInformationSequence1", (IndexReferenceInformationSequence1) o.getIndexReferenceInformationSequence1() != null ? 1 : 0, 0, 1), 
				checkCardinality("indexSeries", (Integer) o.getIndexSeries() != null ? 1 : 0, 0, 1), 
				checkCardinality("indexAnnexVersion", (Integer) o.getIndexAnnexVersion() != null ? 1 : 0, 0, 1), 
				checkCardinality("indexAnnexDate", (Date) o.getIndexAnnexDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("indexAnnexSource", (IndexAnnexSource) o.getIndexAnnexSource() != null ? 1 : 0, 0, 1), 
				checkCardinality("tranche", (Tranche) o.getTranche() != null ? 1 : 0, 0, 1), 
				checkCardinality("settledEntityMatrix", (SettledEntityMatrix) o.getSettledEntityMatrix() != null ? 1 : 0, 0, 1), 
				checkCardinality("indexReferenceInformationSequence2", (IndexReferenceInformationSequence2) o.getIndexReferenceInformationSequence2() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<IndexReferenceInformation> validate(RosettaPath path, IndexReferenceInformation o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("IndexReferenceInformation", ValidationType.CARDINALITY, "IndexReferenceInformation", path, "", error);
		}
		return success("IndexReferenceInformation", ValidationType.CARDINALITY, "IndexReferenceInformation", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, IndexReferenceInformation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("IndexReferenceInformation", ValidationType.CARDINALITY, "IndexReferenceInformation", path, "", res.getError());
				}
				return success("IndexReferenceInformation", ValidationType.CARDINALITY, "IndexReferenceInformation", path, "");
			})
			.collect(toList());
	}

}
