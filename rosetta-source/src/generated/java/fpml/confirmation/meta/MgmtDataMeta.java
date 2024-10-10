package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.MgmtData;
import fpml.confirmation.validation.MgmtDataTypeFormatValidator;
import fpml.confirmation.validation.MgmtDataValidator;
import fpml.confirmation.validation.exists.MgmtDataOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=MgmtData.class)
public class MgmtDataMeta implements RosettaMetaData<MgmtData> {

	@Override
	public List<Validator<? super MgmtData>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MgmtData, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super MgmtData> validator() {
		return new MgmtDataValidator();
	}

	@Override
	public Validator<? super MgmtData> typeFormatValidator() {
		return new MgmtDataTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MgmtData, Set<String>> onlyExistsValidator() {
		return new MgmtDataOnlyExistsValidator();
	}
}
