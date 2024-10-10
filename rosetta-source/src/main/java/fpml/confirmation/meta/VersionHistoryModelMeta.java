package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.VersionHistoryModel;
import fpml.confirmation.validation.VersionHistoryModelTypeFormatValidator;
import fpml.confirmation.validation.VersionHistoryModelValidator;
import fpml.confirmation.validation.exists.VersionHistoryModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=VersionHistoryModel.class)
public class VersionHistoryModelMeta implements RosettaMetaData<VersionHistoryModel> {

	@Override
	public List<Validator<? super VersionHistoryModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super VersionHistoryModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super VersionHistoryModel> validator() {
		return new VersionHistoryModelValidator();
	}

	@Override
	public Validator<? super VersionHistoryModel> typeFormatValidator() {
		return new VersionHistoryModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super VersionHistoryModel, Set<String>> onlyExistsValidator() {
		return new VersionHistoryModelOnlyExistsValidator();
	}
}
